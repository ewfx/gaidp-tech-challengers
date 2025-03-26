import React, { useState } from 'react';
import { processTransactions } from '../services/api';

const DataDisplay = () => {
    const [data, setData] = useState([]);

    const fetchData = () => {
        processTransactions(sampleData).then(response => {
            setData(response.data);
        });
    };

    return (
        <div>
            <button onClick={fetchData}>Process Data</button>
            <ul>
                {data.map((item, index) => (
                    <li key={index}>{JSON.stringify(item)}</li>
                ))}
            </ul>
        </div>
    );
};

export default DataDisplay;