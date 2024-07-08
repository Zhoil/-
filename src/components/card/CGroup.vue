<template>
  <div class="cgroup">
    <h2>Select Friend(s)</h2>
    <div v-for="(option, index) in options" :key="index" class="checkbox-container">
      <input
          type="checkbox"
          :id="'checkbox-' + index"
          v-model="selectedOptions"
          :value="option.value"
      />
      <label :for="'checkbox-' + index">{{ option.label }}</label>
    </div>
    <div class="selected-options">
      <h3>Selected Options:</h3>
      <ul>
        <li v-for="(option, index) in selectedOptions" :key="index">{{ option }}</li>
      </ul>
    </div>
    <button @click="sendData">Send Data</button>
  </div>
</template>

<script>
export default {
  name: 'CGroup',
  data() {
    return {
      options: [
        { label: 'Alice-in', value: 'Alice' },
        { label: 'Bob-in', value: 'Bob' },
        { label: 'zh-in', value: 'zh' },
      ],
      selectedOptions: [],
    };
  },
  methods: {
    sendData() {
      const data = JSON.stringify({ selectedOptions: this.selectedOptions });
      console.log(data);
      window.opener.postMessage(data, '*');
    }
  }
};
</script>

<style scoped>
.cgroup {
  font-family: Arial, sans-serif;
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 8px;
  background-color: #f9f9f9;
}

h2 {
  text-align: center;
  color: #333;
}

.checkbox-container {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

input[type='checkbox'] {
  margin-right: 10px;
}

label {
  cursor: pointer;
}

.selected-options {
  margin-top: 20px;
}

.selected-options ul {
  list-style-type: none;
  padding: 0;
}

.selected-options li {
  background-color: #e7f3fe;
  border: 1px solid #d3e3f5;
  border-radius: 4px;
  padding: 5px 10px;
  margin-bottom: 5px;
}
</style>
