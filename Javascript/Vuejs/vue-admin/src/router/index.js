import { createRouter, createWebHistory } from 'vue-router';
import Signup from '../components/ComSignup.vue';
import Login from '../components/ComLogin.vue';
import Home from "@/components/ComHome.vue";
import ProductDetail from "@/components/ComProductDetail.vue";
import Cart from "@/components/ComCart.vue";
import UserDetail from "@/components/ComUserDetail.vue";
import OrderHistory from "@/components/ComOrderHistory.vue";
import Admin from "@/components/admin/ComAdmin.vue";

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/signup',
        name: 'SignUp',
        component: Signup
    },
    {
        path: '/product/:id',
        name: 'ProductDetail',
        component: ProductDetail
    },
    {
        path: '/cart',
        name: 'Cart',
        component: Cart
    },
    {
        path: '/user',
        name: 'UserDetail',
        component: UserDetail
    },
    {
        path: '/order-history',
        name: 'OrderHistory',
        component: OrderHistory,
    },
    {
        path: '/admin',
        name: 'Admin',
        component: Admin,
    },

    // Các route khác...
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
