import logo from './logo.svg';
import './App.css';
import { getByTitle } from '@testing-library/react';

function demodata(){
  return[
    {
      id: 1,
      title: "test1",
      statu: false,
    },
    {
      id: 2,
      title: "test2",
      statu: true,
    },
    {
      id: 3,
      title: "test3",
      statu: true,
    },
    {
      id: 4,
      title: "test4",
      statu: true,
    },
  ];
}

function App1(){
  const demos = demodata();
  return(
    <ul>
      {demos.map((demo) => (
        <li>
          <input type="checkbox" defaultChecked={demo.statu} />
          <label>{demo.title}</label>
        </li>
      ))}

    </ul>
  );
}

export default App1;
