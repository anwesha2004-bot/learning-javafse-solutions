import React, { Component } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      view: 'books',
      books: [
        { title: "React Basics", author: "Dan Abramov" },
        { title: "JavaScript Essentials", author: "Kyle Simpson" }
      ],
      blogs: [
        { title: "Why React Rocks", topic: "React" },
        { title: "Understanding JSX", topic: "JSX" }
      ],
      courses: [
        { name: "Full Stack Development", duration: "6 months" },
        { name: "Data Science", duration: "1 year" }
      ]
    };
  }

  renderComponent = () => {
    const { view, books, blogs, courses } = this.state;

    // Multiple ways of conditional rendering

    // 1. if-else style
    if (view === 'books') {
      return <BookDetails books={books} />;
    }

    // 2. ternary operator
    return view === 'blogs' ? (
      <BlogDetails blogs={blogs} />
    ) : view === 'courses' ? (
      <CourseDetails courses={courses} />
    ) : (
      <p>No view selected.</p>
    );
  };

  render() {
    return (
      <div style={{ textAlign: 'center', padding: '30px' }}>
        <h1> Blogger Dashboard</h1>

        {/* View Selection Buttons */}
        <div style={{ marginBottom: '20px' }}>
          <button onClick={() => this.setState({ view: 'books' })}>Show Books</button>
          <button onClick={() => this.setState({ view: 'blogs' })}>Show Blogs</button>
          <button onClick={() => this.setState({ view: 'courses' })}>Show Courses</button>
        </div>

        {/* Conditional content */}
        {this.renderComponent()}
      </div>
    );
  }
}

export default App;
