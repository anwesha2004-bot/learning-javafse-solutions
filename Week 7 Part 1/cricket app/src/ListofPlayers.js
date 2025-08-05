import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: "Dhoni", score: 100 }, // 🌟 Thala on top!
    { name: "Rohit", score: 90 },
    { name: "Virat", score: 45 },
    { name: "Gill", score: 80 },
    { name: "Hardik", score: 35 },
    { name: "Jadeja", score: 77 },
    { name: "Pant", score: 60 },
    { name: "Iyer", score: 88 },
    { name: "Kishan", score: 40 },
    { name: "Bumrah", score: 72 },
    { name: "Siraj", score: 55 },
    { name: "Kuldeep", score: 95 }
  ];

  const lowScorers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>

      <h3>Players Scoring Below 70</h3>
      <ul>
        {lowScorers.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
