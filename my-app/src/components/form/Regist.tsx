import * as React from "react";
import { Fragment } from "react";
import { Link } from "react-router-dom";
import "../../Regist.css";


export default class Regist extends React.Component< any, any >{

    public genderArr = ["男","女"];
    public titleArr = ["--------","综合职","专门职"];

    public constructor(props:any){
        super(props)
        this.state={
            name : "",
            age :  "",
            gender : "男",
            title : "--------",
            task : [],
            taskArr : ["吃饭", "睡觉", "打豆豆"],
            addTask : ""
        }

        this.handleInput= this.handleInput.bind(this);
        this.handleInputTask = this.handleInputTask.bind(this);
        this.handleAddTask = this.handleAddTask.bind(this);
        // this.handleSubmit= this.handleSubmit.bind(this);
        this.handleDelTask = this.handleDelTask.bind(this);
    }

    public handleInput(e: any){
        const inputName = e.target.name;
        const inputValue = e.target.value;
        this.setState(
            {
                [ inputName ] : inputValue
            }
        )
    }

    public handleInputTask(e: any){
        const inputValue = e.target.value;
        let arr = [...this.state.task];
        if(arr.indexOf(inputValue) >= 0){
            arr.splice(arr.indexOf(inputValue),1);
        }else{
            arr.push(inputValue);
        }

        this.setState(
            {
                task : arr
            }
        )
    }

    public handleAddTask(){
        const inputValue = this.state.addTask;
        let arr = [...this.state.taskArr];
        if(arr.indexOf(inputValue) < 0){
            arr.push(inputValue);
            this.setState(
                {
                    taskArr : arr,
                    addTask : ""
                }
            )
        }else{
            alert("已经存在的任务！");
            return;
        }

    }

    public handleDelTask(){
        const checkedArr = this.state.task;
        let arr = [...this.state.taskArr];
        
        if(checkedArr.length <= 0){
            alert("请选择任务！");
            return;          
        }else{
            for(let i=0;i<checkedArr.length;i++){           
                arr.splice(arr.indexOf(checkedArr[i]),1)
            }
            this.setState(
                {
                    taskArr : arr,
                    task : []
                }
            )
        }

    }

    
    public handleSubmit(e:any){
        console.table(this.state);
        e.preventDefault();

        const data = { 
            name : this.state.name,
            age :  this.state.age,
            gender : this.state.gender,
            title : this.state.title,
            task : this.state.task
         };

        var path = {
            pathname:'/Profile',
            state:data,
        }

        this.props.history.push(path);
    }
    
    

    public render(){

        return(
            <Fragment>
                <form className="inputForm" onSubmit={this.handleSubmit}>
                    <table className="inputTable">
                        <tbody>
                            <tr>
                                <th></th>
                                <th></th>
                            </tr>
                            <tr>
                                <td>名字:</td>
                                <td><input name="name" type="text" value={ this.state.name } onChange={ this.handleInput } />
                                </td>
                            </tr>
                            <tr>
                                <td>年龄:</td>
                                <td> 
                                    <input name="age" type="text" value={ this.state.age } onChange={ this.handleInput } />
                                </td>
                            </tr>
                            <tr>
                                <td>性别:</td>
                                <td> 
                                    {
                                        this.genderArr.map((item : string,index : number) => {
                                            return[
                                                <label key={ index + item}>
                                                    <input 
                                                        name= "gender"
                                                        type= "radio" 
                                                        value={ item }
                                                        onChange={ this.handleInput }
                                                    />
                                                    <Fragment> { item } </Fragment>         
                                                </label> 
                                            ]  
                                        })
                                    }
                                </td>
                            </tr>
                            <tr>
                                <td>职称:</td>
                                <td>
                                    <select name="title" value={ this.state.title} onChange={ this.handleInput }>
                                        {
                                            this.titleArr.map((item : string,index : number) => {
                                                return(
                                                    <option key={ index+item }>{ item }</option>
                                                )
                                            })
                                        }
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>任务:</td>
                                <td> 
                                    {
                                        this.state.taskArr.map((item : string,index : number) => {
                                            return[
                                                <label key={ index + item}>
                                                    <input 
                                                        name= "task"
                                                        type= "checkbox" 
                                                        value= {item}
                                                        checked= { this.state.task.indexOf(item)>=0 ? true:false }
                                                        onChange= { this.handleInputTask }
                                                    />
                                                    <Fragment> { item } </Fragment>         
                                                </label> 
                                            ]  
                                        })
                                    }
                                </td>
                            </tr>
                            <tr>
                                <td>添加任务:</td>
                                <td> 
                                    <input name="addTask" type="text" value={ this.state.addTask } onChange={ this.handleInput } />
                                    <button type="button" onClick={ this.handleAddTask }>添加</button>
                                </td>
                            </tr>
                            <tr>
                                <td>删除任务:</td>
                                <td> 
                                    <button type="button" onClick={ this.handleDelTask }>勾选任务后删除</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    
                    <table>
                        <tbody>
                            <tr>
                                <td>
                                        <button type="submit">提交</button>
                                </td>
                                <td>
                                    <Link to="/">
                                        <button type="button">返回主页</button>
                                    </Link>
                                </td>
                            </tr>
                        </tbody>
                    </table>                  
                </form>
                <br />
                <br /> 
        
            </Fragment>           
        )
    }
}