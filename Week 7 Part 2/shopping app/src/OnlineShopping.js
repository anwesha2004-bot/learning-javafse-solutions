import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  render() {
    const items = [
      { itemname: "Laptop", price: 50000 },
      { itemname: "Smartphone", price: 20000 },
      { itemname: "Headphones", price: 2000 },
      { itemname: "Shoes", price: 3000 },
      { itemname: "Backpack", price: 1500 }
    ];

    return (
      <div>
        <h2>Welcome to Online Shopping</h2>
        {items.map((item, index) => (
          <Cart key={index} itemname={item.itemname} price={item.price} />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;
