import { Box, Grid } from "@mui/material";
import React from "react";
import HomePage from "./component/HomePage";
import { Header, Body, Footer, Menu} from "./layout/LayoutIndex";

interface Ipages{
    id: number,
    menuName: string,
    title: string,
    pageContent: JSX.Element
}

function App(){

    const [value, setValue] = React.useState(
        {
            id: 0,
            menuName: "主页",
            title: "主页",
            pageContent: <HomePage />
        }
    );

    function handleGoToBody(bodypage: Ipages){
        setValue({   
            id : bodypage.id,
            menuName : bodypage.menuName,
            title : bodypage.title,
            pageContent : bodypage.pageContent
        });
    }

    return(

        <Box m={4}>
            <Grid container spacing={2}>
                <Grid item xs={12}>        
                    <Header />
                </Grid>
                <Grid item xs={3} >        
                    <Menu handleGoToBody={handleGoToBody}/>
                </Grid>   
                <Grid item xs={9}>
                     <Body bodyPage={value} />
                </Grid>     
                <Grid item xs={12}>
                    <Footer />
                </Grid>                
            </Grid> 
        </Box>
    );
}

export default App;




