import React, { useState } from 'react';
import './App.css';

const REGISTER = 'REGISTER';
const GET_INFO = 'GET_INFO';
const EDIT_INFO = 'EDIT_INFO';

function App() {
  const [screen, setScreen] = useState(null);

  let screenHtml;
  if (screen === REGISTER) {
    screenHtml = <div>REGISTER</div>;
  }
  if (screen === GET_INFO) {
    screenHtml = <div>GET_INFO</div>;
  }
  if (screen === EDIT_INFO) {
    screenHtml = <div>EDIT_INFO</div>;
  }

  return (
    <div className="contapp">
      <header className="contapp-header">
        <div>Contapp Bare Bones Sandbox</div>
        <div className="features">
          <button className="link" onClick={() => setScreen(REGISTER)}>
            Register
          </button>
          <button className="link" onClick={() => setScreen(GET_INFO)}>
            Get Info
          </button>
          <button className="link" onClick={() => setScreen(EDIT_INFO)}>
            Edit Info
          </button>
        </div>
      </header>
      <div className="mock-page">{screenHtml}</div>
    </div>
  );
}

export default App;
