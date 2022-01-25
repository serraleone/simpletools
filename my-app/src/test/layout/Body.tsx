import React from "react";
import { Box, Grid, Paper, Typography } from "@mui/material";

// interface Ipages{
//     id: number,
//     menuName: string,
//     title: string,
//     pageContent: JSX.Element
// }

export default function Body(props: any){
    // console.table(props.bodyPage);
    return(
        <Box bgcolor="#e0f7fa" style={{height: 600}}> 
            <Grid container justifyContent="center">
                <Grid item xs={12}>
                    <Box bgcolor="#e0f7fa" style={{height: 10}}/> 
                </Grid>
                <Grid item xs={12}>
                    <Typography style={{textAlign: "center"}} variant="h4">{props.bodyPage.title}</Typography>          
                </Grid>
                <Grid item xs={12}>
                    <Box bgcolor="#e0f7fa" style={{height: 10}}/> 
                </Grid>
                <Grid item xs="auto">
                    <Box bgcolor="#e0f7fa" style={{height: 500, width:3}}/> 
                </Grid>
                <Grid item xs={11.5}>  
                    <Paper style={{height: 530}}>
                        {props.bodyPage.pageContent}
                    </Paper>
                </Grid>
            </Grid>
        </Box>
    );
}

