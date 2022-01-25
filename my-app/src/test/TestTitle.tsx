import React from "react";

function TestTitle(props : any){
    const { title, handleChange} = props;

    return(
        <div>
            <h1>{ title }</h1>
            <button onClick={()=>handleChange("这里是第三个")}>更改标题</button>
        </div>
    );

}

export default TestTitle;