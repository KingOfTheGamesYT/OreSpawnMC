/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelCliffRacer
/*     */   extends ModelBase {
/*  10 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer Body;
/*     */   
/*     */   ModelRenderer Fins;
/*     */   ModelRenderer LWing;
/*     */   ModelRenderer RWing;
/*     */   ModelRenderer Tail;
/*     */   ModelRenderer TailEnd;
/*     */   ModelRenderer Head;
/*     */   ModelRenderer Beak;
/*     */   
/*     */   public ModelCliffRacer(float f1) {
/*  23 */     this.wingspeed = f1;
/*     */     
/*  25 */     this.textureWidth = 64;
/*  26 */     this.textureHeight = 64;
/*     */     
/*  28 */     this.Body = new ModelRenderer(this, 0, 52);
/*  29 */     this.Body.addBox(0.0F, 0.0F, 0.0F, 3, 1, 10);
/*  30 */     this.Body.setRotationPoint(-1.0F, 15.0F, -4.0F);
/*  31 */     this.Body.setTextureSize(64, 64);
/*  32 */     this.Body.mirror = true;
/*  33 */     setRotation(this.Body, 0.0F, 0.0F, 0.0F);
/*  34 */     this.Fins = new ModelRenderer(this, 0, 40);
/*  35 */     this.Fins.addBox(0.0F, -4.0F, 0.0F, 1, 6, 3);
/*  36 */     this.Fins.setRotationPoint(0.0F, 15.0F, -1.0F);
/*  37 */     this.Fins.setTextureSize(64, 64);
/*  38 */     this.Fins.mirror = true;
/*  39 */     setRotation(this.Fins, 0.0F, 0.0F, 0.0F);
/*  40 */     this.LWing = new ModelRenderer(this, 0, 31);
/*  41 */     this.LWing.addBox(0.0F, 0.0F, 0.0F, 7, 1, 6);
/*  42 */     this.LWing.setRotationPoint(2.0F, 15.0F, -2.0F);
/*  43 */     this.LWing.setTextureSize(64, 64);
/*  44 */     this.LWing.mirror = true;
/*  45 */     setRotation(this.LWing, 0.0F, 0.0F, 0.0F);
/*  46 */     this.RWing = new ModelRenderer(this, 39, 0);
/*  47 */     this.RWing.addBox(-7.0F, 0.0F, 0.0F, 7, 1, 6);
/*  48 */     this.RWing.setRotationPoint(-1.0F, 15.0F, -2.0F);
/*  49 */     this.RWing.setTextureSize(64, 64);
/*  50 */     this.RWing.mirror = true;
/*  51 */     setRotation(this.RWing, 0.0F, 0.0F, 0.0F);
/*  52 */     this.Tail = new ModelRenderer(this, 0, 16);
/*  53 */     this.Tail.addBox(0.0F, 0.0F, 0.0F, 1, 1, 9);
/*  54 */     this.Tail.setRotationPoint(0.0F, 15.0F, 6.0F);
/*  55 */     this.Tail.setTextureSize(64, 64);
/*  56 */     this.Tail.mirror = true;
/*  57 */     setRotation(this.Tail, 0.0F, 0.0F, 0.0F);
/*  58 */     this.TailEnd = new ModelRenderer(this, 0, 10);
/*  59 */     this.TailEnd.addBox(0.0F, -1.0F, 9.0F, 2, 2, 2);
/*  60 */     this.TailEnd.setRotationPoint(-0.5F, 15.0F, 6.0F);
/*  61 */     this.TailEnd.setTextureSize(64, 64);
/*  62 */     this.TailEnd.mirror = true;
/*  63 */     setRotation(this.TailEnd, 0.0F, 0.0F, 0.0F);
/*  64 */     this.Head = new ModelRenderer(this, 28, 21);
/*  65 */     this.Head.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
/*  66 */     this.Head.setRotationPoint(-0.5F, 14.0F, -6.0F);
/*  67 */     this.Head.setTextureSize(64, 64);
/*  68 */     this.Head.mirror = true;
/*  69 */     setRotation(this.Head, 0.0F, 0.0F, 0.0F);
/*  70 */     this.Beak = new ModelRenderer(this, 0, 0);
/*  71 */     this.Beak.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
/*  72 */     this.Beak.setRotationPoint(0.0F, 14.5F, -8.0F);
/*  73 */     this.Beak.setTextureSize(64, 64);
/*  74 */     this.Beak.mirror = true;
/*  75 */     setRotation(this.Beak, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  80 */     float newangle = 0.0F;
/*  81 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  82 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  85 */     newangle = MathHelper.cos(f2 * 1.3F * this.wingspeed) * 3.1415927F * 0.25F;
/*  86 */     this.LWing.rotateAngleZ = newangle;
/*  87 */     this.RWing.rotateAngleZ = -newangle;
/*     */ 
/*     */     
/*  90 */     this.Body.render(f5);
/*  91 */     this.Fins.render(f5);
/*  92 */     this.LWing.render(f5);
/*  93 */     this.RWing.render(f5);
/*  94 */     this.Tail.render(f5);
/*  95 */     this.TailEnd.render(f5);
/*  96 */     this.Head.render(f5);
/*  97 */     this.Beak.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 103 */     model.rotateAngleX = x;
/* 104 */     model.rotateAngleY = y;
/* 105 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 110 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelCliffRacer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */