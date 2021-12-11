import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import CreateTicket from "./components/create_ticket/CreateTicket"

ReactDOM.render(
  <React.StrictMode>
    <CreateTicket />
  </React.StrictMode>,
  document.getElementById('root')
);

