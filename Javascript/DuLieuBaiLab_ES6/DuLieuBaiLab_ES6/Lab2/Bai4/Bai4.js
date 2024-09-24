document.addEventListener('DOMContentLoaded', () => {
    const productList = document.getElementById('product-list');
    const cartList = document.getElementById('cart-list');
    const totalPrice = document.getElementById('total-price');
  
    const products = [
      { name: 'Nước Ép Cam', price: 30000 },
      { name: 'Trà Sữa', price: 40000 },
      { name: 'Cà Phê Đen', price: 20000 },
      { name: 'Sinh Tố Bơ', price: 50000 }
    ];
  
    let cart = [];
  
    const renderProducts = () => {
      productList.innerHTML = products.map(product => `
        <div class="product">
          <span>${product.name} - ${product.price} VND</span>
          <button onclick="addToCart('${product.name}')">Thêm</button>
        </div>
      `).join('');
    };
  
    const renderCart = () => {
      cartList.innerHTML = cart.map(item => `
        <div class="cart-item">
          <span>${item.name} - ${item.price} VND - Số lượng: ${item.quantity}</span>
          <button class="remove-btn" onclick="removeFromCart('${item.name}')">Xóa</button>
        </div>
      `).join('');
      totalPrice.textContent = cart.reduce((total, item) => total + item.price * item.quantity, 0);
    };
  
    window.addToCart = (productName) => {
      const product = products.find(p => p.name === productName);
      const cartItem = cart.find(item => item.name === productName);
      
      if (cartItem) {
        cartItem.quantity++;
      } else {
        cart.push({ ...product, quantity: 1 });
      }
      
      renderCart();
    };
  
    window.removeFromCart = (productName) => {
      cart = cart.filter(item => item.name !== productName);
      renderCart();
    };
  
    renderProducts();
    renderCart();
  });