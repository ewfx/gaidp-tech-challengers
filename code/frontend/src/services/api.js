import axios from 'axios';

export const processTransactions = (data) => {
    return axios.post('/api/profiling/process', data);
};