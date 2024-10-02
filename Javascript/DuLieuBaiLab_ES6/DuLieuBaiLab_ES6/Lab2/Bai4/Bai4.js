const products = [
  { id: 1, name: 'Nước Ép Cam', price: 30000 },
  { id: 2, name: 'Trà Sữa', price: 40000 },
  { id: 3, name: 'Cà Phê Đen', price: 20000 },
  { id: 4, name: 'Sinh Tố Bơ', price: 50000 },
];

// Biến lưu trữ giỏ hàng
let cart = [];

// Tạo danh sách sản phẩm
const productlist = document.getElementById('product-list');
const renderProduct = () => {
  products.forEach((gt) => {
    // Tạo div chứa sản phẩm
    const div = document.createElement('div');
    div.classList.add('product');
    const { id, name, price } = gt;
    div.innerHTML = `
      <span>${name}</span>
      <span>${price} VND</span>
      <button onclick="addToCart(${id})">Thêm</button>
    `;
    productlist.appendChild(div);
  });
};

// Gọi hàm renderProduct để hiển thị danh sách sản phẩm
renderProduct();

// Hàm thêm sản phẩm vào giỏ hàng
const addToCart = (id) => {
  const sanpham = products.find(item => item.id === id);
  const spghang = cart.find(item => item.id === id);

  if (spghang) {
    spghang.quantity++;
  } else {
    const spnew = { ...sanpham, quantity: 1 };
    cart = [...cart, spnew];
  }

  // Cập nhật giỏ hàng
  renderCart();
};

// Hàm hiển thị giỏ hàng
const cartlist = document.getElementById('cart-list');
const renderCart = () => {
  cartlist.innerHTML = '';
  cart.forEach(item => {
    const div = document.createElement('div');
    div.classList.add('cart-item');
    const { id, name, price, quantity } = item;
    div.innerHTML = `
      <span>${name}</span>
      <span>${price} VND</span>
      <span>Số lượng: ${quantity}</span>
      <button class="remove-btn" onclick="removeFromCart(${id})">Xóa</button>
    `;
    cartlist.appendChild(div);
  });

  // Tính tổng giá trị giỏ hàng
  const totalprice = document.getElementById('total-price');
  const tong = cart.reduce((total, item) => total + item.price * item.quantity, 0);
  totalprice.textContent = `Tổng: ${tong} VND`;
};

// Hàm xóa sản phẩm khỏi giỏ hàng
const removeFromCart = (id) => {
  const productIndex = cart.findIndex(item => item.id === id);

  if (productIndex !== -1) {
    if (cart[productIndex].quantity > 1) {
      cart[productIndex].quantity--;
    } else {
      cart.splice(productIndex, 1);
    }

    // Cập nhật giỏ hàng sau khi xóa
    renderCart();
  }
};
