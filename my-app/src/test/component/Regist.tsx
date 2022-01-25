import * as React from "react";
import { Fragment } from "react";
import "../../Regist.css";

interface Iprops{
    name : string,
    age : string,
    gender : string,
    title : string,
    task : Array<string>,
    addTask : string,
    taskArr : Array<string>
    
}

export default function Regist(props: any){

    const genderArr = ["男","女"];
    const titleArr = ["--------","综合职","专门职"];

    const [value, setValue] = React.useState<Iprops>({
        name : "",
        age :  "",
        gender : "男",
        title : "--------",
        task : [],
        addTask : "",
        taskArr : ["吃饭", "睡觉", "打豆豆"]
    });

    function handleInput(e: any){
        const inputName = e.target.name;
        const inputValue = e.target.value;
        setValue({ ...value, [inputName]: inputValue });
    }

    function handleInputTask(e: any){
        const inputValue = e.target.value;
        let arr = [...value.task];
        if(arr.indexOf(inputValue) >= 0){
            arr.splice(arr.indexOf(inputValue),1);
        }else{
            arr.push(inputValue);
        }

        setValue({ ...value, task : arr });
    }

    function handleAddTask(){
        const inputValue = value.addTask;
        let arr = [...value.taskArr];
        if(arr.indexOf(inputValue) < 0){
            arr.push(inputValue);
            
            setValue({ ...value, taskArr : arr, addTask : "" });
        }else{
            alert("已经存在的任务！");
            return;
        }
        

    }

    function handleDelTask(){
        const checkedArr = value.task;
        let arr = [...value.taskArr];
        
        if(checkedArr.length <= 0){
            alert("请选择任务！");
            return;          
        }else{
            for(let i=0;i<checkedArr.length;i++){           
                arr.splice(arr.indexOf(checkedArr[i]),1)
            }
            setValue({ ...value, task : [], taskArr : arr});
        }

    }

    
    function handleSubmit(e:any){
        e.preventDefault();

        const data = { 
            name : value.name,
            age :  value.age,
            gender : value.gender,
            title : value.title,
            task : value.task
         };

        var path = {
            pathname:'/Profile',
            state:data,
        }

        props.history.push(path);
    }
    
    return(
            <Fragment>
                <form className="inputForm" onSubmit={handleSubmit}>
                    <table className="inputTable">
                        <tbody>
                            <tr>
                                <th></th>
                                <th></th>
                            </tr>
                            <tr>
                                <td>名字:</td>
                                <td><input name="name" type="text" value={ value.name } onChange={ handleInput } />
                                </td>
                            </tr>
                            <tr>
                                <td>年龄:</td>
                                <td> 
                                    <input name="age" type="text" value={ value.age } onChange={ handleInput } />
                                </td>
                            </tr>
                            <tr>
                                <td>性别:</td>
                                <td> 
                                    {
                                        genderArr.map((item : string,index : number) => {
                                            return[
                                                <label key={ index + item}>
                                                    <input 
                                                        name= "gender"
                                                        type= "radio" 
                                                        value={ item }
                                                        onChange={ handleInput }
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
                                    <select name="title" value={ value.title} onChange={ handleInput }>
                                        {
                                            titleArr.map((item : string,index : number) => {
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
                                        value.taskArr.map((item : string,index : number) => {
                                            return[
                                                <label key={ index + item}>
                                                    <input 
                                                        name= "task"
                                                        type= "checkbox" 
                                                        value= {item}
                                                        checked= { value.task.indexOf(item)>=0 ? true:false }
                                                        onChange= { handleInputTask }
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
                                    <input name="addTask" type="text" value={ value.addTask } onChange={ handleInput } />
                                    <button type="button" onClick={ handleAddTask }>添加</button>
                                </td>
                            </tr>
                            <tr>
                                <td>删除任务:</td>
                                <td> 
                                    <button type="button" onClick={ handleDelTask }>勾选任务后删除</button>
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
                                        <button type="button">返回主页</button>
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
