import React from 'react';
import PropTypes from 'prop-types';

function Subtitle({ text }) {
  return <h4>{text}</h4>;
}

Subtitle.propTypes = {
  text: PropTypes.string.isRequired,
};

export default Subtitle;
