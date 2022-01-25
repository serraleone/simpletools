import React from "react";
import { BottomNavigation, BottomNavigationAction, Box, Divider } from "@mui/material";
import { Fragment } from "react";
import FavoriteIcon from "@material-ui/icons/Favorite";
import LocationOnIcon from "@material-ui/icons/LocationOn";
import RestoreIcon from "@material-ui/icons/Restore";

function Footer(){
    return(
        <Fragment>
            <Divider color="#e0e0e0"/>
            <Box>
                    <BottomNavigation  showLabels>
                        <BottomNavigationAction label="Recents" icon={<RestoreIcon />} />
                        <BottomNavigationAction label="Favorites" icon={<FavoriteIcon />} />
                        <BottomNavigationAction label="Nearby" icon={<LocationOnIcon />} />
                    </BottomNavigation>     
            </Box>
        </Fragment>
    );
}

export default Footer;