import React, { Component } from "react";
import { Link } from "react-router-dom";

export default class AppMeau extends Component{

    public render(){
        return(
            <div>
                <Link to="/Regist">
                   <button type="button">注册</button>
                </Link>             
            </div>
        )
    }
}