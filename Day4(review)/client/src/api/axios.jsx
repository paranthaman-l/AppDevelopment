import axios from 'axios'
const userApi = axios.create({
    baseURL:process.env.REACT_APP_SERVER_USER_BASE_URL,
})
const otpApi = axios.create({
    baseURL:process.env.REACT_APP_SERVER_OTP_BASE_URL,
})

export { userApi,otpApi };