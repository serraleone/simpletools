import React, { Component, Fragment } from "react";
import { Link } from "react-router-dom";

import "../Regist.css";


// interface IProps{
//     name : string;
//     age :  string;
//     gender : string;
//     title : string;
//     task : Array<string>;
// }

export default class Profile extends Component<any, any>{

    public constructor(props:any){
        super(props);
        
    }
       

    public render(){
        const state = this.props.location.state;
        return(
            <Fragment>
                <h1>注册信息</h1>
                <br />
                <br />
                <table>
                    <tbody>
                        <tr>
                            <td>姓名:</td>
                            <td>{ state.name }</td>
                        </tr>
                        <tr>
                            <td>年龄:</td>
                            <td>{ state.age }</td>
                        </tr>
                        <tr>
                            <td>性别:</td>
                            <td>{state.gender}</td>
                        </tr>
                        <tr>
                            <td>职位:</td>
                            <td>{ state.title }</td>
                        </tr>
                        <tr>
                            <td>任务:</td>
                            <td>
                                { 
                                    state.task.map((item : string,index : number) => {return (item + " ")})
                                }
                            </td>
                        </tr>
                    </tbody>
                </table>
                <br />
                <Link to="/Regist">
                    <button type="button">返回主页</button>
               </Link>

            </Fragment>
        )
    }
}