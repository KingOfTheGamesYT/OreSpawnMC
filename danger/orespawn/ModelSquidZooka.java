/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelSquidZooka
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Barrel;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer tail3;
/*     */   ModelRenderer tail4;
/*     */   ModelRenderer tail5;
/*     */   ModelRenderer tail6;
/*     */   ModelRenderer tail7;
/*     */   ModelRenderer sight3;
/*     */   ModelRenderer sight2;
/*     */   ModelRenderer sight1;
/*     */   ModelRenderer handle1;
/*     */   
/*     */   public ModelSquidZooka() {
/*  28 */     this.textureWidth = 128;
/*  29 */     this.textureHeight = 128;
/*     */     
/*  31 */     this.Barrel = new ModelRenderer(this, 29, 19);
/*  32 */     this.Barrel.addBox(-1.0F, -1.0F, -19.0F, 2, 2, 34);
/*  33 */     this.Barrel.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  34 */     this.Barrel.setTextureSize(128, 128);
/*  35 */     this.Barrel.mirror = true;
/*  36 */     setRotation(this.Barrel, 0.0F, 0.0F, 0.0F);
/*  37 */     this.tail1 = new ModelRenderer(this, 0, 53);
/*  38 */     this.tail1.addBox(-1.5F, -1.5F, 15.0F, 3, 3, 1);
/*  39 */     this.tail1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  40 */     this.tail1.setTextureSize(128, 128);
/*  41 */     this.tail1.mirror = true;
/*  42 */     setRotation(this.tail1, 0.0F, 0.0F, 0.0F);
/*  43 */     this.tail2 = new ModelRenderer(this, 0, 58);
/*  44 */     this.tail2.addBox(-2.0F, -2.0F, 16.0F, 4, 4, 1);
/*  45 */     this.tail2.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  46 */     this.tail2.setTextureSize(128, 128);
/*  47 */     this.tail2.mirror = true;
/*  48 */     setRotation(this.tail2, 0.0F, 0.0F, 0.0F);
/*  49 */     this.tail3 = new ModelRenderer(this, 0, 64);
/*  50 */     this.tail3.addBox(-2.5F, -2.5F, 17.0F, 5, 5, 1);
/*  51 */     this.tail3.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  52 */     this.tail3.setTextureSize(128, 128);
/*  53 */     this.tail3.mirror = true;
/*  54 */     setRotation(this.tail3, 0.0F, 0.0F, 0.0F);
/*  55 */     this.tail4 = new ModelRenderer(this, 0, 71);
/*  56 */     this.tail4.addBox(-3.0F, -3.0F, 18.0F, 6, 6, 6);
/*  57 */     this.tail4.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  58 */     this.tail4.setTextureSize(128, 128);
/*  59 */     this.tail4.mirror = true;
/*  60 */     setRotation(this.tail4, 0.0F, 0.0F, 0.0F);
/*  61 */     this.tail5 = new ModelRenderer(this, 0, 84);
/*  62 */     this.tail5.addBox(-2.5F, -2.5F, 24.0F, 5, 5, 1);
/*  63 */     this.tail5.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  64 */     this.tail5.setTextureSize(128, 128);
/*  65 */     this.tail5.mirror = true;
/*  66 */     setRotation(this.tail5, 0.0F, 0.0F, 0.0F);
/*  67 */     this.tail6 = new ModelRenderer(this, 0, 91);
/*  68 */     this.tail6.addBox(-2.0F, -2.0F, 25.0F, 4, 4, 1);
/*  69 */     this.tail6.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  70 */     this.tail6.setTextureSize(128, 128);
/*  71 */     this.tail6.mirror = true;
/*  72 */     setRotation(this.tail6, 0.0F, 0.0F, 0.0F);
/*  73 */     this.tail7 = new ModelRenderer(this, 0, 97);
/*  74 */     this.tail7.addBox(-1.5F, -1.5F, 26.0F, 3, 3, 1);
/*  75 */     this.tail7.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  76 */     this.tail7.setTextureSize(128, 128);
/*  77 */     this.tail7.mirror = true;
/*  78 */     setRotation(this.tail7, 0.0F, 0.0F, 0.0F);
/*  79 */     this.sight3 = new ModelRenderer(this, 25, 0);
/*  80 */     this.sight3.addBox(1.0F, -2.0F, -10.0F, 1, 1, 2);
/*  81 */     this.sight3.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  82 */     this.sight3.setTextureSize(128, 128);
/*  83 */     this.sight3.mirror = true;
/*  84 */     setRotation(this.sight3, 0.0F, 0.0F, 0.0F);
/*  85 */     this.sight2 = new ModelRenderer(this, 32, 0);
/*  86 */     this.sight2.addBox(0.5F, -4.0F, -12.0F, 2, 2, 6);
/*  87 */     this.sight2.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  88 */     this.sight2.setTextureSize(128, 128);
/*  89 */     this.sight2.mirror = true;
/*  90 */     setRotation(this.sight2, 0.0F, 0.0F, 0.0F);
/*  91 */     this.sight1 = new ModelRenderer(this, 18, 0);
/*  92 */     this.sight1.addBox(1.0F, -1.0F, -10.0F, 1, 1, 2);
/*  93 */     this.sight1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  94 */     this.sight1.setTextureSize(128, 128);
/*  95 */     this.sight1.mirror = true;
/*  96 */     setRotation(this.sight1, 0.0F, 0.0F, 0.0F);
/*  97 */     this.handle1 = new ModelRenderer(this, 0, 0);
/*  98 */     this.handle1.addBox(0.0F, 1.0F, 0.0F, 1, 7, 1);
/*  99 */     this.handle1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 100 */     this.handle1.setTextureSize(128, 128);
/* 101 */     this.handle1.mirror = true;
/* 102 */     setRotation(this.handle1, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render() {
/* 107 */     float f5 = 1.0F;
/*     */ 
/*     */     
/* 110 */     GL11.glPushMatrix();
/*     */     
/* 112 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 113 */     this.Barrel.render(f5);
/* 114 */     this.tail1.render(f5);
/* 115 */     this.tail2.render(f5);
/* 116 */     this.tail3.render(f5);
/* 117 */     this.tail4.render(f5);
/* 118 */     this.tail5.render(f5);
/* 119 */     this.tail6.render(f5);
/* 120 */     this.tail7.render(f5);
/* 121 */     this.sight3.render(f5);
/* 122 */     this.sight2.render(f5);
/* 123 */     this.sight1.render(f5);
/* 124 */     this.handle1.render(f5);
/* 125 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 130 */     model.rotateAngleX = x;
/* 131 */     model.rotateAngleY = y;
/* 132 */     model.rotateAngleZ = z;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelSquidZooka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */