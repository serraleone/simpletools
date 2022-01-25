import React, { useState } from "react";
import TestTitle from "./TestTitle";


function Header(){

    const [ title , setTitle ] = useState("这是第一个");

    const handleChange = (title : any) => {
        setTitle(title);
    } 
    return(
        <div className="Header">
            <TestTitle title={title} handleChange={ handleChange} />
        </div>
    );
}

export default Header;