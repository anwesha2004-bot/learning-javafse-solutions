import React, { Component } from 'react';

class Cart extends Component {
  static defaultProps = {
    itemname: "Unknown Item",
    price: "N/A"
  };

  render() {
    return (
      <div style={{ border: '1px solid gray', margin: '10px', padding: '10px' }}>
        <h3>Item: {this.props.itemname}</h3>
        <p>Price: ₹{this.props.price}</p>
      </div>
    );
  }
}

export default Cart;
