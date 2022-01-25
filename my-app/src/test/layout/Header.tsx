import React from "react";
import { Box, Grid,Typography } from "@mui/material";

function Header(){
    return(
        <Box bgcolor="#2196f3" style={{width: "100%"}}>
            <Grid container justifyContent="center">   
                <Typography variant="h2" color="white">
                    菜单
                </Typography>

            </Grid>   
        </Box>
    );
}

export default Header;