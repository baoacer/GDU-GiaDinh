<template>
  <div class="user-management">
    <h2 class="title">Quản lý người dùng</h2>
    <h3 class="subtitle">Danh sách người dùng</h3>
    <ul class="user-list">
      <li v-for="user in users" :key="user.userId" class="user-item">
        <span class="user-ID">{{ user.userId }}</span>
        <span class="user-fullname">{{ user.fullname }}</span>
        <span class="user-phone">{{ user.phoneNumber }}</span>
        <span class="user-status">- Trạng thái: {{ user.isActive ? 'Kích hoạt' : 'Khóa' }}</span>
        <button class="toggle-button" @click="toggleUserStatus(user.userId, user.isActive)">
          {{ user.isActive ? 'Khóa tài khoản' : 'Kích hoạt tài khoản' }}
        </button>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      users: [],
    };
  },
  mounted() {
    this.fetchUsers();
  },
  methods: {
    async fetchUsers() {
      const token = localStorage.getItem('accessToken');
      try {
        const response = await axios.get('http://localhost:2999/api/users', {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
        this.users = response.data; // Gán dữ liệu cho users
        console.log(this.users); // Kiểm tra dữ liệu trả về
      } catch (error) {
        console.error('Error fetching users:', error); // Kiểm tra lỗi
      }
    },
    async toggleUserStatus(userId, isActive) {
      const token = localStorage.getItem('accessToken');
      try {
        await axios.put(`http://localhost:2999/api/users/${userId}`, { isActive: !isActive }, {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
        await this.fetchUsers(); // Cập nhật danh sách người dùng sau khi thay đổi trạng thái
      } catch (error) {
        console.error('Error toggling user status:', error); // Kiểm tra lỗi
      }
    },
  },
};
</script>
<style scoped>
.user-management {
  padding: 20px;
  background-color: #ffffff; /* Màu nền trắng cho toàn bộ component */
  border-radius: 8px; /* Bo góc cho container */
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Hiệu ứng bóng */
}

.title {
  margin-bottom: 10px; /* Khoảng cách dưới tiêu đề */
  color: #333; /* Màu chữ cho tiêu đề */
  font-size: 24px; /* Kích thước chữ lớn hơn */
}

.subtitle {
  margin-bottom: 20px; /* Khoảng cách dưới tiêu đề phụ */
  color: #555; /* Màu chữ cho tiêu đề phụ */
  font-size: 20px; /* Kích thước chữ cho tiêu đề phụ */
}

.user-list {
  list-style-type: none; /* Bỏ dấu chấm đầu dòng */
  padding: 0; /* Bỏ padding */
}

.user-item {
  padding: 15px; /* Padding cho các mục người dùng */
  border: 1px solid #e0e0e0; /* Đường viền nhẹ */
  border-radius: 4px; /* Bo góc cho các mục người dùng */
  margin-bottom: 15px; /* Khoảng cách giữa các mục */
  display: flex; /* Sử dụng flexbox để căn chỉnh */
  justify-content: space-between; /* Căn giữa các phần tử */
  align-items: center; /* Căn giữa theo chiều dọc */
  background-color: #f9f9f9; /* Màu nền nhẹ cho các mục người dùng */
  transition: background-color 0.3s; /* Hiệu ứng chuyển màu nền */
}

.user-item:hover {
  background-color: #e9ecef; /* Màu nền khi hover */
}

.user-ID {
  font-weight: bold; /* Chữ đậm cho email */
}

.user-phone {
  color: #666; /* Màu chữ cho số điện thoại */
}

.user-status {
  color: #666; /* Màu chữ cho trạng thái */
}

.toggle-button {
  background-color: #007bff; /* Màu nền cho nút */
  color: white; /* Màu chữ cho nút */
  border: none; /* Bỏ đường viền */
  border-radius: 4px; /* Bo góc cho nút */
  padding: 10px 15px; /* Padding cho nút */
  cursor: pointer; /* Con trỏ khi hover */
  transition: background-color 0.3s; /* Hiệu ứng chuyển màu nền */
}

.toggle-button:hover {
  background-color: #0056b3; /* Màu nền khi hover */
}
</style>