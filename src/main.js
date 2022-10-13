import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

import PrimeVue from 'primevue/config'
import Button from 'primevue/button';
import TabMenu from 'primevue/tabmenu';
import InputText from 'primevue/inputtext';
import ToastService from 'primevue/toastservice';
import Toast from 'primevue/toast';
import InputMask from 'primevue/inputmask';
import Checkbox from 'primevue/checkbox';
import CascadeSelect from 'primevue/cascadeselect';
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import Row from 'primevue/row';
import Dropdown from 'primevue/dropdown';
import Chart from 'primevue/chart';


import 'primevue/resources/themes/saga-blue/theme.css'
import 'primevue/resources/primevue.min.css'
import 'primeicons/primeicons.css'

const app = createApp(App);
app.use(PrimeVue)
app.use(router)
app.use(ToastService)

app.component('Button', Button);
app.component('Chart', Chart);
app.component('TabMenu', TabMenu);
app.component('DataTable', DataTable);
app.component('Column', Column);
app.component('Row', Row);
app.component('InputText', InputText);
app.component('Toast', Toast);
app.component('InputMask', InputMask);
app.component('Checkbox', Checkbox);
app.component('CascadeSelect', CascadeSelect);
app.component('Dropdown', Dropdown);

app.mount('#app')
