import React from 'react';
import MenuList from '@material-ui/core/MenuList';
import MenuItem from '@material-ui/core/MenuItem';
import Typography from '@material-ui/core/Typography';
import { Box } from '@mui/material';
import HomePage from '../component/HomePage';
import Regist from '../component/Regist';

// interface Iprops{
//     handleGoToBody: Function
// }

const menuList = ["主页", "用户登录", "检索", "用户一览"];

const bodyPages = [
    {
        id: 0,
        menuName: "主页",
        title: "主页",
        pageContent: <HomePage />
    },
    {
        id: 1,
        menuName: "用户登录",
        title: "用户登录界面",
        pageContent: <Regist />
    },
    {
        id: 2,
        menuName: "检索",
        title: "检索界面",
        pageContent: <HomePage />
    },
    {
        id: 3,
        menuName: "用户一览",
        title: "用户一览界面",
        pageContent: <HomePage />
    }
];

export default function Menu(props: any) {

    // console.table(props.handleGoToBody);

    return (
        
        <Box bgcolor="grey.300" style={{height: 600}} >
                <MenuList>
                    {
                        menuList.map((item : string, index : number) => {
                            
                            for(let v of bodyPages){
                                if(v.menuName===item){
                                    let bodyPage=v;

                                    return(
                                        <MenuItem key={index+item} onClick={()=>props.handleGoToBody(bodyPage)}>
                                            <Typography variant="inherit">{item}</Typography> 
                                        </MenuItem>
                                    );
                                }
                            }

                            return null;


                            // console.table(props.handleGoToBody);
                        })
                    }
                </MenuList>
        </Box>
        
    );
}