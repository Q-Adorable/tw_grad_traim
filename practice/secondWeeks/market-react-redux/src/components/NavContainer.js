import React from 'react';
import {
  Nav, NavItem, NavLink
} from 'reactstrap';
import { NavLink as NavLinkRouter } from 'react-router-dom';
const NavContainer = () => {
  return (
    <Nav tabs>
      <NavLinkRouter exact to="/" className="nav-tabs nav-link" activeClassName="active">
        商城
      </NavLinkRouter>
      <NavLinkRouter exact to="/cart" className="nav-tabs nav-link" activeClassName="active">
        购物车
      </NavLinkRouter>
    </Nav>);
}

export default NavContainer;