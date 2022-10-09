import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('../views/AboutView.vue')
  },
  {
    path: '/marca',
    name: 'marca',
    component: () => import('../views/MarcaView.vue')
  },
  {
    path: '/marca-form/:id',
    name: 'marca-form',
    component: () => import('../views/MarcaFormView.vue')
  }, 
  {
    path: '/marca-form',
    name: 'marca-form-new',
    component: () => import('../views/MarcaFormView.vue')
  },   
  {
    path: '/carro',
    name: 'carro',
    component: () => import('../views/CarroView.vue')
  },
  {
    path: '/carro-form',
    name: 'carro-form-new',
    component: () => import('../views/CarroFormView.vue')
  },
  {
    path: '/cor',
    name: 'cor',
    component: () => import('../views/CorCarroView.vue')
  },
  {
    path: '/cor-form/:id',
    name: 'cor-form',
    component: () => import('../views/CorCarroFormView.vue')
  }, 
  {
    path: '/cor-form',
    name: 'cor-form-new',
    component: () => import('../views/CorCarroFormView.vue')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
