import React from 'react';
import './Navbar.css';

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="navbar-l">Ems</div>
      <div className="navbar-r">
        <a href="/">Login</a>
        <a href="/register">Register</a>
      </div>
    </nav>
  );
};

export default Navbar;
