<template>
  <div>
    <Product :products="products"></Product>
  </div>
</template>

<script>
import axios from 'axios';
import Product from "@/components/ComProduct.vue";

export default {
  components: {
    Product
  },
  data() {
    return {
      products: []
    };
  },
  async created() {
    await this.fetchProducts();
  },
  methods: {
    async fetchProducts() {
      try {
        const response = await axios.get('http://localhost:2999/api/products');
        this.products = response.data;
      } catch (error) {
        console.error('Error fetching products:', error);
      }
    }
  }
}
</script>

<style scoped>
</style>