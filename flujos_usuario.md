# FLUJOS_USUARIO.md

## 🚀 Flujos Principales del Usuario

Este documento describe los flujos funcionales que los usuarios siguen dentro de la aplicación. Los flujos están pensados para validar que todas las acciones deseadas pueden realizarse de forma lógica, intuitiva y completa.

---

### 🧑‍🔧 1. Registro y configuración inicial

**Objetivo:** Crear cuenta y preparar perfil

**Pasos:**
1. Usuario accede a pantalla de registro.
2. Ingresa correo electrónico y contraseña segura.
3. El sistema valida y crea cuenta.
4. Usuario sube fotografía de perfil.
5. El sistema sugiere categorías y cuentas comunes (opcional).
6. Usuario decide si las acepta o crea las propias.

---

### 📝 2. Registro de gasto o ingreso diario

**Objetivo:** Añadir movimiento financiero con contexto

**Pasos:**
1. Usuario selecciona tipo: gasto o ingreso.
2. Ingresa monto, fecha y descripción.
3. Elige categoría y cuenta asociada.
4. Escribe nota recordatoria (opcional).
5. Adjunta fotografía del movimiento (opcional).
6. Guarda registro; se actualiza el balance.

---

### 📊 3. Consulta de reportes

**Objetivo:** Ver resumen por rango de fechas

**Pasos:**
1. Usuario abre módulo de reportes.
2. Elige tipo de reporte (`daily`, `weekly`, `monthly`, `custom`).
3. Ingresa fechas límite o selecciona rango.
4. El sistema muestra totales por cuenta, categoría y saldo neto.
5. Usuario puede exportar o compartir el reporte (en futuras versiones).

---

### 🔍 4. Búsqueda contextual

**Objetivo:** Encontrar movimientos específicos

**Pasos:**
1. Usuario accede a historial de movimientos.
2. Usa filtro por nota, cuenta o categoría.
3. Opcional: activa vista con miniaturas de fotos.
4. Consulta y amplía detalles si desea.

---

### 🎯 5. Creación y seguimiento de metas

**Objetivo:** Ahorrar para un objetivo personal

**Pasos:**
1. Usuario crea una meta con monto y período.
2. Asocia ingresos y gastos a la meta.
3. El sistema muestra avance porcentual.
4. Se generan alertas de progreso o desviación.

---

### 🔐 6. Modo privado y visualización discreta

**Objetivo:** Consultar datos con privacidad reforzada

**Pasos:**
1. Usuario activa "modo privado".
2. Montos se ocultan o muestran con PIN/biometría.
3. Opcional: activa visualización por gráficos o avatar emocional.

---

### 🔄 7. Edición o eliminación de movimientos

**Objetivo:** Corregir registro reciente

**Pasos:**
1. Usuario accede a detalle del movimiento.
2. Si está dentro del límite permitido (ej. 48h), puede editar o eliminar.
3. El sistema registra acción en historial (bitácora).
4. Se actualizan saldos, metas y reportes asociados.

---

### 🧠 Flujos futuros

- Consulta de ubicación donde se realizó el gasto.
- Interacción grupal (familia o socios).
- Recomendaciones inteligentes en base a hábitos.

---

Este archivo puede crecer junto con tus casos de uso y sirve como guía de pruebas de usuario, UX y validación de reglas de negocio.

