import { post } from './client';

const SIGN_UP_PATH = '/sign-up';

const signUp = async (details) => {
    return post(SIGN_UP_PATH, details);
};

export { signUp };
