import React, { Component } from 'react';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    // Step: Declare state
    this.state = {
      entryCount: 0,
      exitCount: 0
    };
  }

  // Step: Method to update entry
  UpdateEntry = () => {
    this.setState({ entryCount: this.state.entryCount + 1 });
  }

  // Step: Method to update exit
  UpdateExit = () => {
    this.setState({ exitCount: this.state.exitCount + 1 });
  }

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h2>Welcome to the Mall</h2>
        <p><strong>People Entered:</strong> {this.state.entryCount}</p>
        <p><strong>People Exited:</strong> {this.state.exitCount}</p>

        <button onClick={this.UpdateEntry} style={{ margin: '10px' }}>Login</button>
        <button onClick={this.UpdateExit} style={{ margin: '10px' }}>Exit</button>
      </div>
    );
  }
}

export default CountPeople;
