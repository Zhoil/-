import Vuex from 'vuex';

const store = new Vuex.Store({
    state: {
        users: [],
        count: 0
    },
    mutations: {
      increment (state) {
          state.count++;
      },
      addUser(state, user) {
          state.users.push(user);
      },
      deleteUser(state, user) {
          state.users.remove(user);
      }

    },

    getters: {
        getUserByName: state => username => {
            return state.users.find(user => user === username);
        }
    }
})

export default store;