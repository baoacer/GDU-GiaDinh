<template>
  <div class="order-history">
    <h3 class="order-title">Lịch sử đơn hàng</h3>
    <table class="order-table">
      <thead>
      <tr>
        <th>Mã đơn hàng</th>
        <th>Ngày đặt</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="order in orders" :key="order.id">
        <td>{{ order.orderId }}</td>
        <td>{{ formatDate(order.orderDate) }}</td>
        <td>{{ order.status }}</td>
        <td>
          <button v-if="order.status === 'Đang xử lý'" @click="cancelOrder(order.id)">Hủy đơn</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      orders: [],
    };
  },
  mounted() {
    this.fetchOrderHistory();
  },
  methods: {
    async fetchOrderHistory() {
      const token = localStorage.getItem('accessToken');
      try {
        const response = await axios.get('http://localhost:2999/api/orders', {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
        this.orders = response.data; // Giả sử API trả về danh sách đơn hàng
      } catch (error) {
        console.error('Error fetching order history:', error);
      }
    },
    async cancelOrder(orderId) {
      const token = localStorage.getItem('accessToken');
      try {
        await axios.delete(`http://localhost:2999/api/orders/${orderId}`, {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
        alert('Đơn hàng đã được hủy thành công');
        await this.fetchOrderHistory(); // Cập nhật lại danh sách đơn hàng
      } catch (error) {
        alert('Hủy đơn hàng thất bại');
        console.error('Error canceling order:', error);
      }
    },
    formatDate(dateString) {
      const options = { year: 'numeric', month: 'long', day: 'numeric' };
      return new Date(dateString).toLocaleDateString('vi-VN', options);
    }
  }
};
</script>

<style scoped>
.order-history {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #f9f9f9;
}

.order-title {
  text-align: center;
  margin-bottom: 20px;
}

.order-table {
  width: 100%;
  border-collapse: collapse;
}

.order-table th, .order-table td {
  padding: 10px;
  text-align: left;
  border: 1px solid #ccc;
}

.order-table th {
  background-color: #007bff;
  color: white;
}

button {
  background-color: #dc3545;
  color: white;
  border: none;
  border-radius: 4px;
  padding: 5px 10px;
  cursor: pointer;
}

button:hover {
  background-color: #c82333;
}
</style>