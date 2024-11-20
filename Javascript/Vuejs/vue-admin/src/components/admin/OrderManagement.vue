<template>
  <div>
    <h2>Quản lý đơn hàng</h2>
    <h3>Danh sách đơn hàng</h3>
    <ul>
      <li v-for="order in orders" :key="order.id">
        Đơn hàng #{{ order.id }} - Trạng thái: {{ order.status }}
        <button @click="updateOrderStatus(order.id, 'confirmed')">Xác nhận thanh toán</button>
        <button @click="updateOrderStatus(order.id, 'shipped')">Đã giao hàng</button>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      orders: [],
    };
  },
  mounted() {
    this.fetchOrders();
  },
  methods: {
    async fetchOrders() {
      const token = localStorage.getItem('accessToken');
      const response = await axios.get('http://localhost:2999/api/orders', {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      this.orders = response.data;
    },
    async updateOrderStatus(orderId, status) {
      const token = localStorage.getItem('accessToken');
      await axios.put(`http://localhost:2999/api/orders/${orderId}`, { status }, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      await this.fetchOrders();
    },
  },
};
</script>

<style scoped>
.order-management {
  padding: 20px;
  background-color: #ffffff; /* Màu nền trắng cho toàn bộ component */
  border-radius: 8px; /* Bo góc cho container */
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Hiệu ứng bóng */
}

.order-management h2 {
  margin-bottom: 10px; /* Khoảng cách dưới tiêu đề */
  color: #333; /* Màu chữ cho tiêu đề */
  font-size: 24px; /* Kích thước chữ lớn hơn */
}

.order-management h3 {
  margin-bottom: 20px; /* Khoảng cách dưới tiêu đề phụ */
  color: #555; /* Màu chữ cho tiêu đề phụ */
  font-size: 20px; /* Kích thước chữ cho tiêu đề phụ */
}

.order-management ul {
  list-style-type: none; /* Bỏ dấu chấm đầu dòng */
  padding: 0; /* Bỏ padding */
}

.order-management li {
  padding: 15px; /* Padding cho các mục đơn hàng */
  border: 1px solid #e0e0e0; /* Đường viền nhẹ */
  border-radius: 4px; /* Bo góc cho các mục đơn hàng */
  margin-bottom: 15px; /* Khoảng cách giữa các mục */
  display: flex; /* Sử dụng flexbox để căn chỉnh */
  justify-content: space-between; /* Căn giữa các phần tử */
  align-items: center; /* Căn giữa theo chiều dọc */
  background-color: #f9f9f9; /* Màu nền nhẹ cho các mục đơn hàng */
  transition: background-color 0.3s; /* Hiệu ứng chuyển màu nền */
}

.order-management li:hover {
  background-color: #e9ecef; /* Màu nền khi hover */
}

.order-management li button {
  background-color: #007bff; /* Màu nền cho nút */
  color: white; /* Màu chữ cho nút */
  border: none; /* Bỏ viền */
  border-radius: 4px; /* Bo góc cho nút */
  padding: 8px 12px; /* Padding cho nút */
  cursor: pointer; /* Con trỏ chuột khi hover */
  transition: background-color 0.3s; /* Hiệu ứng chuyển màu nền cho nút */
}

.order-management li button:hover {
  background-color: #0056b3; /* Màu nền khi hover */
}
</style>