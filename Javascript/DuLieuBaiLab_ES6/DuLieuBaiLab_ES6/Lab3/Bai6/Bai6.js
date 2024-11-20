document.addEventListener('DOMContentLoaded', () => {
    const CartManager = {
        cart: [],
        
        addProduct(id, price) {
            return new Promise(resolve => {
                setTimeout(() => {
                    this.cart.push({ id, price: parseFloat(price) });
                    resolve();
                }, 200);
            });
        },

        calculateTotal() {
            return new Promise(resolve => {
                setTimeout(() => {
                    const total = this.cart.reduce((sum, item) => sum + item.price, 0);
                    resolve(total);
                }, 200);
            });
        },

        getCart() {
            return this.cart;
        }
    };

    const UIManager = {
        cartList: document.getElementById('cart'),
        checkoutButton: document.getElementById('checkout'),
        messageElement: document.getElementById('message'),

        init() {
            this.bindEvents();
            this.renderCart();
        },

        bindEvents() {
            document.querySelectorAll('.add-to-cart').forEach(button => {
                button.addEventListener('click', this.handleAddToCart.bind(this));
            });

            this.checkoutButton.addEventListener('click', this.handleCheckout.bind(this));
        },

        async handleAddToCart(event) {
            event.preventDefault();
            const productElement = event.target.closest('.product');
            const { id, price } = productElement.dataset;

            await CartManager.addProduct(id, price);
            this.renderCart();
        },

        async handleCheckout() {
            const total = await CartManager.calculateTotal();
            this.messageElement.textContent = `Total: $${total.toFixed(2)}`;
        },

        renderCart() {
            this.cartList.innerHTML = '';
            CartManager.getCart().forEach(item => {
                const li = document.createElement('li');
                li.textContent = `Product ${item.id} - $${item.price.toFixed(2)}`;
                this.cartList.appendChild(li);
            });
        }
    };

    UIManager.init();
});