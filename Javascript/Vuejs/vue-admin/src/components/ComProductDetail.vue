<template>
  <main>
    <div class="container">
      <div class="product-detail" v-if="product">
        <div class="product-gallery">
          <div class="main-image">
            <img :src="getImageUrl(product.ImageURL)" alt="Main Product Image">
          </div>
        </div>

        <div class="product-description">
          <h3 class="product-name">{{ product.ProductName }}</h3>
          <div class="description">{{ product.Description }}</div>
          <div class="product-price">
            <span class="price">{{ getPriceRange(product.ProductSizes) }}</span>
          </div>

          <div class="product-size">
            <div class="choose-size">Chọn Size</div>
            <select v-model="selectedSize" @change="updatePrice" style="padding: 5px 0">
              <option v-for="size in product.ProductSizes" :key="size.ProductSizeID" :value="size">
                {{ getSizeLabel(size.Size) }} ({{ formatCurrency(size.Price) }})
              </option>
            </select>
          </div>

          <div class="product-counter">
            <button class="counter-btn" @click="decreaseCounter">-</button>
            <span class="counter-value">{{ counter }}</span>
            <button class="counter-btn" @click="increaseCounter">+</button>
          </div>

          <div class="button-container">
            <button class="btn add-to-cart" @click="addToCart">
              <span class="icon">🛒</span>
              Thêm Vào Giỏ Hàng
            </button>
            <button class="btn buy-now" @click="buyNow">Mua Ngay</button>
          </div>
        </div>
      </div>
      <div v-else>
        <p>Loading...</p>
      </div>
    </div>
  </main>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      product: null,
      counter: 1,
      selectedSize: null,
    };
  },
  async mounted() {
    const id = this.$route.params.id;
    await this.fetchProduct(id);
  },
  methods: {
    async fetchProduct(id) {
      try {
        const response = await axios.get(`http://localhost:2999/api/products/${id}`);
        this.product = response.data;
        if (this.product.ProductSizes.length > 0) {
          this.selectedSize = this.product.ProductSizes[0];
        }
        console.log("size", this.product.ProductSizes)
      } catch (error) {
        console.error('Error fetching product:', error);
      }
    },
    formatCurrency(value) {
      return new Intl.NumberFormat('vi-VN', {
        style: 'currency',
        currency: 'VND',
      }).format(value);
    },
    getSizeLabel(size) {
      switch (size) {
        case 'Small':
          return 'M';
        case 'Medium':
          return 'L';
        case 'Large':
          return 'XL';
        default:
          return size;
      }
    },
    getPriceRange(sizes) {
      if (!sizes || sizes.length === 0) return 'Liên hệ';
      const prices = sizes.map(size => size.Price);
      const minPrice = Math.min(...prices);
      const maxPrice = Math.max(...prices);
      if (minPrice === maxPrice) {
        return this.formatCurrency(minPrice);
      } else {
        return `${this.formatCurrency(minPrice)} - ${this.formatCurrency(maxPrice)}`;
      }
    },
    increaseCounter() {
      this.counter++;
    },
    decreaseCounter() {
      if (this.counter > 1) {
        this.counter--;
      }
    },
    getImageUrl(imageName) {
      return require(`@/assets/image/${imageName}`);
    },
    updatePrice() {
      console.log('Selected size:', this.selectedSize);
    },
    addToCart() {
      const cartItems = JSON.parse(localStorage.getItem('cartItems')) || [];
      const existingItem = cartItems.find(item => item.id === this.product.ProductID && item.size === this.selectedSize.Size);
      if (existingItem) {
        existingItem.quantity += this.counter;
      } else {
        cartItems.push({
          id: this.product.ProductID,
          name: this.product.ProductName,
          image: this.product.ImageURL,
          price: this.selectedSize.Price,
          quantity: this.counter,
          size: this.selectedSize.ProductSizeID
        });
      }
      console.log(cartItems);
      localStorage.setItem('cartItems', JSON.stringify(cartItems));
      alert('Sản phẩm đã được thêm vào giỏ hàng!');
    },
    buyNow() {
      this.addToCart();
      this.$router.push('/cart');
    }
  }
}
</script>

<style scoped>

.description{
  text-align: left;
}
.choose-size{
  text-align: left;
  margin-bottom: 5px;
  font-size: 20px;
}


body{
  font-family: Mulish, sans-serif;
}

.product-detail{
  display: flex;
  width: 80%;
  margin: 0 auto;
  gap: 20px;
}

.product-description{
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.product-name{
  text-align: left;
}

.product-price{
  display: flex;
  justify-content: left;
}

.product-counter {
  display: inline-flex;
  align-items: center;
  width: 104px;
  border: 1px solid #ddd;
  border-radius: 4px;
  overflow: hidden;
}

.counter-btn {
  width: 30px;
  height: 30px;
  border: none;
  background: none;
  cursor: pointer;
  font-size: 20px;
  color: #888;
  outline: none;
}

.counter-value {
  width: 40px;
  text-align: center;
  font-size: 16px;
  color: #333;
  border-left: 1px solid #ddd;
  border-right: 1px solid #ddd;
}

.button-container {
  display: flex;
  gap: 10px;
}

.btn {
  padding: 10px 20px;
  font-size: 16px;
  font-weight: bold;
  border-radius: 4px;
  cursor: pointer;
  outline: none;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  gap: 5px;
}

.add-to-cart {
  border: 2px solid #f56c42;
  background-color: #fff5f2;
  color: #f56c42;
  margin-right: 10px;
}

.buy-now {
  border: none;
  background-color: #f56c42;
  color: #ffffff;
}

.add-to-cart:hover {
  background-color: #ffe1d9;
}

.buy-now:hover {
  background-color: #e65a30;
}

.product-gallery {
  width: 300px; /* Điều chỉnh theo yêu cầu */
  margin: auto;
}

.main-image {
  position: relative;
  width: 100%;
}

.main-image img {
  width: 100%;
  border-radius: 8px;
}

.promotion-banner span:first-child {
  background-color: #ff5e00;
  padding: 3px 5px;
  border-radius: 3px;
}


.thumbnail-gallery img {
  width: 50px; /* Điều chỉnh kích thước theo yêu cầu */
  height: 50px;
  cursor: pointer;
  border: 2px solid transparent;
  border-radius: 4px;
}

.thumbnail-gallery img:hover,
.thumbnail-gallery img.active {
  border-color: #ff4500;
}

.price {
  font-size: 24px;
  font-weight: bold;
  color: #FF5733;
}
</style>
