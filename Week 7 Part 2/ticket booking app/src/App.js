import React, { Component } from 'react';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false
    };
  }

  // Toggle Login/Logout
  handleLogin = () => {
    this.setState({ isLoggedIn: true });
  };

  handleLogout = () => {
    this.setState({ isLoggedIn: false });
  };

  render() {
    let content;

    if (this.state.isLoggedIn) {
      // 🟢 User Page
      content = (
        <div style={{ textAlign: 'center' }}>
          <h1>Welcome User ✈️</h1>
          <p>Flight: Kolkata → Bangalore</p>
          <p>Departure: 3:30 PM | Arrival: 6:00 PM</p>
          <p>Price: ₹4500</p>
          <button>Book Now</button>
          <br /><br />
          <button onClick={this.handleLogout}>Logout</button>
        </div>
      );
    } else {
      // 🔵 Guest Page
      content = (
        <div style={{ textAlign: 'center' }}>
          <h1>Welcome Guest 👋</h1>
          <p>You can browse available flights but need to login to book tickets.</p>
          <p>Flight: Kolkata → Bangalore</p>
          <p>Departure: 3:30 PM | Arrival: 6:00 PM</p>
          <p>Price: ₹4500</p>
          <button disabled>Book Now</button>
          <br /><br />
          <button onClick={this.handleLogin}>Login</button>
        </div>
      );
    }

    return <div>{content}</div>;
  }
}

export default App;
