import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: '',
      euro: ''
    };
  }

  handleChange = (event) => {
    this.setState({ rupees: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    // Assume 1 Euro = 90 Rupees
    const euroValue = parseFloat(this.state.rupees) / 90;
    this.setState({ euro: euroValue.toFixed(2) });
  };

  render() {
    return (
      <div style={{ textAlign: 'center', padding: '30px' }}>
        <h2>Currency Convertor</h2>
        <form onSubmit={this.handleSubmit}>
          <input
            type="number"
            placeholder="Enter amount in ₹"
            value={this.state.rupees}
            onChange={this.handleChange}
            style={{ padding: '5px', width: '200px' }}
          />
          <br /><br />
          <button type="submit" style={{ padding: '5px 10px' }}>
            Convert
          </button>
        </form>

        {this.state.euro && (
          <p style={{ marginTop: '20px' }}>
            💶 Euro: €{this.state.euro}
          </p>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;
