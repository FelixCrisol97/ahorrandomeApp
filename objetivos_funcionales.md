# Objetivos Funcionales del Proyecto de Registro de Gastos e Ingresos

Esta aplicación tiene como finalidad ofrecer al usuario una herramienta completa, modular y personalizada para gestionar sus movimientos financieros diarios, con enfoque visual, analítico y recordatorio. Los siguientes objetivos funcionales definen los comportamientos y capacidades que el sistema debe cumplir.

---

## 🧾 Registro de Movimientos

- Registrar **gastos** e **ingresos** diarios vinculados a un usuario.
- Agregar **nota personalizada** por movimiento.
- Adjuntar **fotografía opcional** (ticket, contexto visual).
- Asociar cada movimiento a una **categoría** y una **cuenta** personalizada.

---

## 🗂️ Personalización

- Crear categorías personalizadas por tipo (`GASTO` o `INGRESO`) y por usuario.
- Definir "cuentas" o billeteras (ej. Auto, Casa, Viajes).
- Subir fotografía de perfil para cada usuario.
- Campos configurables: nombre de cuentas, categorías, notas.

---

## 🔐 Autenticación y gestión de usuario

- Registro de usuario con email y contraseña.
- Login con token JWT seguro.
- Subida y edición de fotografía de perfil.
- Acceso protegido a movimientos e historial por usuario.

---

## 📊 Reportes y estadísticas

- Consultar reportes por rango de fechas (`daily`, `weekly`, `monthly`, `custom`).
- Ver totales por cuenta, categoría y tipo.
- Generar reportes visuales del balance entre ingresos y gastos.
- Filtros por nota o categoría específica.
- Opcional: exportación futura como PDF, Excel o JSON.

---

## 🚨 Alertas e inteligencia financiera

- Notificaciones por gasto atípico o excesivo.
- Detectar patrones repetitivos y estimar gastos futuros.
- Consejos personalizados según hábitos financieros.

---

## 🎯 Metas y eventos

- Crear metas de ahorro vinculadas a movimientos.
- Agrupar movimientos por evento (ej. "Vacaciones 2025").
- Mostrar avances porcentuales y alertas de cumplimiento.

---

## 🌐 Funcionalidades adicionales

- Modo privado: ocultar montos en público o bajo PIN.
- Multimoneda y formato de fecha flexible por zona.
- Geolocalización opcional del gasto (si el usuario lo permite).
- Dashboard visual con gráficas, frases motivadoras y vista con miniaturas de fotos.
- Onboarding inicial: sugerencia de categorías/cuentas según perfil.
- Soporte accesible: diseño responsivo, modo oscuro y UX amigable.
- Bitácora de edición/eliminación de movimientos (historial de acciones).

---

## 🔁 Posibles integraciones futuras

- Importación de movimientos desde CSV/Excel.
- Sincronización con Google Calendar (eventos financieros).
- Compartir reportes por correo o mensajería instantánea.
- Lectura automática de correos SAT/bancarios.
- Roles grupales (familia, pareja, socios) con consolidación financiera compartida.

---

## 🧠 Reglas de negocio preliminares

- No se permiten gastos con fecha futura.
- Las categorías y cuentas deben tener nombre único por usuario.
- Un gasto o ingreso puede editarse solo dentro de las 48 horas posteriores.
- Si se elimina una categoría, los movimientos asociados deben reasignarse o marcarse como “sin categoría”.

---

## 🗺️ Flujos de usuario clave

1. Usuario nuevo → registro → subida de foto → primer gasto diario.
2. Usuario activo → consulta de balance → búsqueda por nota → revisión visual.
3. Usuario con meta → asociación de gasto → avance de meta → alerta motivadora.
4. Usuario curioso → generación de reporte → exploración por cuenta y categoría.

---

Este documento servirá como guía base para el modelado de dominio, los casos de uso, la arquitectura hexagonal y los tests de aceptación.

