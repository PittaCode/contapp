import React from 'react';
import PropTypes from 'prop-types';

function SuperTitle({ text }) {
  return <h1>{text}</h1>;
}

SuperTitle.propTypes = {
  text: PropTypes.string.isRequired,
};

export default SuperTitle;
