import axios from 'axios';

const axiosService = axios.create({
  baseURL: 'http://155.138.148.230:3000/',
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json'
  }
});

// singleton instance
export default axiosService;