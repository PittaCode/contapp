import React from 'react';
import Card from 'react-bootstrap/Card';
import Title from '../Headings/Title';

const wrapWithPageLayout = (header, component) => {
  return (
    <Card style={{ margin: '1rem 1rem' }}>
      <Card.Header>
        <Title text={header} />
      </Card.Header>
      <Card.Body>{component}</Card.Body>
    </Card>
  );
};

const wrapWithNarrowPageLayout = (header, component) => {
  return (
    <Card style={{ margin: '1rem 10rem' }}>
      <Card.Header>
        <Title text={header} />
      </Card.Header>
      <Card.Body>{component}</Card.Body>
    </Card>
  );
};

export {
  wrapWithPageLayout,
  wrapWithNarrowPageLayout
};
