/*     */ package com.cyrius.informes;
/*     */ 
/*     */ import com.cyrius.entities.Medico;
/*     */ import com.cyrius.entities.Persona;
/*     */ import com.cyrius.entities.Turno;
/*     */ import com.framework.dynamicForms.entities.DynamicForm;
/*     */ import com.framework.entities.DynamicFormDecorator;
/*     */ import com.framework.persistence.PersistenceService;
/*     */ import com.framework.persistence.PersistibleObject;
/*     */ import java.math.BigInteger;
/*     */ import java.util.Date;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ public class Informe
/*     */   implements DynamicFormDecorator, PersistibleObject
/*     */ {
/*     */   private Long id;
/*     */   private DynamicForm form;
/*     */   private Turno turno;
/*     */   private Medico medicoRealizante;
/*     */   private Date fecha;
/*     */   private String datosXML;
/*     */   private BigInteger nroProtocolo;
/*     */ 
/*     */   public BigInteger getNroProtocolo()
/*     */   {
/*  39 */     asignarNroProtocolo();
/*  40 */     return this.nroProtocolo;
/*     */   }
/*     */ 
/*     */   public void setNroProtocolo(BigInteger nroProtocolo) {
/*  44 */     this.nroProtocolo = nroProtocolo;
/*     */   }
/*     */ 
/*     */   public Date getFecha() {
/*  48 */     return this.fecha;
/*     */   }
/*     */ 
/*     */   public void setFecha(Date fecha) {
/*  52 */     this.fecha = fecha;
/*     */   }
/*     */ 
/*     */   public DynamicForm getForm() {
/*  56 */     return this.form;
/*     */   }
/*     */ 
/*     */   public void setForm(DynamicForm form) {
/*  60 */     this.form = form;
/*     */   }
/*     */ 
/*     */   public Medico getMedicoRealizante() {
/*  64 */     return this.medicoRealizante;
/*     */   }
/*     */ 
/*     */   public void setMedicoRealizante(Medico medicoRealizante) {
/*  68 */     this.medicoRealizante = medicoRealizante;
/*     */   }
/*     */ 
/*     */   public Turno getTurno() {
/*  72 */     return this.turno;
/*     */   }
/*     */ 
/*     */   public void setTurno(Turno turno) {
/*  76 */     this.turno = turno;
/*     */   }
/*     */ 
/*     */   public String getDatosXML() {
/*  80 */     return this.datosXML;
/*     */   }
/*     */ 
/*     */   public void setDatosXML(String datosXML) {
/*  84 */     this.datosXML = datosXML;
/*     */   }
/*     */ 
/*     */   public void finishForm(String xmlData)
/*     */   {
/*  89 */     setDatosXML(xmlData);
/*  90 */     this.turno.setRealizado(Boolean.TRUE);
/*     */ 
/*  92 */     PersistenceService.getInstance().save(this.turno);
/*  93 */     asignarNroProtocolo();
/*  94 */     PersistenceService.getInstance().save(this);
/*  95 */     JOptionPane.showMessageDialog(null, 
/*  96 */       "Se grabo exitosamente el protocolo n°: " + 
/*  97 */       getNroProtocolo());
/*     */   }
/*     */ 
/*     */   private void asignarNroProtocolo()
/*     */   {
/* 104 */     if (this.nroProtocolo == null)
/* 105 */       this.nroProtocolo = PersistenceService.getInstance()
/* 106 */         .getSequenceVelue("sq_numero_protocolo");
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 110 */     return this.form.getName();
/*     */   }
/*     */ 
/*     */   public Long getId() {
/* 114 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 118 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getDestinationName() {
/* 122 */     return this.turno.getPaciente().toString();
/*     */   }
/*     */ 
/*     */   public BigInteger getNro() {
/* 126 */     return getNroProtocolo();
/*     */   }
/*     */ 
/*     */   public void validate()
/*     */   {
/*     */   }
/*     */ 
/*     */   public boolean isPersisted()
/*     */   {
/* 135 */     return this.id != null;
/*     */   }
/*     */ }

/* Location:           E:\cyrius.ultimo\cyrius\cyrius.jar
 * Qualified Name:     com.cyrius.informes.Informe
 * JD-Core Version:    0.6.0
 */