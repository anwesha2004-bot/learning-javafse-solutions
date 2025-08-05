import React, { Component } from 'react';

class EventExamples extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0
    };
  }

  // Method to increment counter
  increment = () => {
    this.setState({ count: this.state.count + 1 });
  };

  // Say hello
  sayHello = () => {
    alert("Hello! Welcome to React Events 🚀");
  };

  // Invoking multiple methods
  handleIncrease = () => {
    this.increment();
    this.sayHello();
  };

  // Method to decrement counter
  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };

  // Method with argument
  sayMessage = (msg) => {
    alert(`Message: ${msg}`);
  };

  // Synthetic event
  handleSyntheticEvent = (e) => {
    e.preventDefault();
    alert("I was clicked! (Synthetic Event)");
  };

  render() {
    return (
      <div style={{ textAlign: 'center', padding: '30px' }}>
        <h2>React Event Handling</h2>
        <p>Counter Value: {this.state.count}</p>

        <button onClick={this.handleIncrease} style={{ margin: '10px' }}>
          Increase
        </button>

        <button onClick={this.decrement} style={{ margin: '10px' }}>
          Decrease
        </button>

        <br /><br />

        <button onClick={() => this.sayMessage("Welcome")} style={{ margin: '10px' }}>
          Say Welcome
        </button>

        <br /><br />

        <button onClick={this.handleSyntheticEvent} style={{ margin: '10px' }}>
          OnPress (Synthetic Event)
        </button>
      </div>
    );
  }
}

export default EventExamples;
