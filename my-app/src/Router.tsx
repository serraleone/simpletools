import {
  BrowserRouter,
  Route,
  Switch,
} from "react-router-dom";
import AppMeau from "./pages/AppMeau";
import Profile from "./pages/Profile";
import Regist from "./components/form/Regist";

function Router() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/" component={AppMeau} />
        <Route exact path="/Regist" component={Regist} />
        <Route exact path="/Profile" component={Profile} />
      </Switch>
    </BrowserRouter>
  );
}

export default Router;