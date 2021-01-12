/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelGhostSkelly
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer body;
/*     */   ModelRenderer shirt;
/*     */   ModelRenderer head;
/*     */   ModelRenderer stem;
/*     */   ModelRenderer rarm;
/*     */   ModelRenderer larm;
/*     */   ModelRenderer rsleeve;
/*     */   ModelRenderer lsleeve;
/*     */   ModelRenderer lchains;
/*     */   ModelRenderer rchains;
/*     */   
/*     */   public ModelGhostSkelly() {
/*  26 */     this.textureWidth = 128;
/*  27 */     this.textureHeight = 64;
/*     */     
/*  29 */     this.body = new ModelRenderer(this, 0, 0);
/*  30 */     this.body.addBox(0.0F, 0.0F, 0.0F, 1, 21, 1);
/*  31 */     this.body.setRotationPoint(0.0F, -1.0F, 0.0F);
/*  32 */     this.body.setTextureSize(128, 64);
/*  33 */     this.body.mirror = true;
/*  34 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  35 */     this.shirt = new ModelRenderer(this, 42, 43);
/*  36 */     this.shirt.addBox(-2.0F, 0.0F, -2.0F, 5, 12, 5);
/*  37 */     this.shirt.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  38 */     this.shirt.setTextureSize(128, 64);
/*  39 */     this.shirt.mirror = true;
/*  40 */     setRotation(this.shirt, 0.0F, 0.0F, 0.0F);
/*  41 */     this.head = new ModelRenderer(this, 40, 29);
/*  42 */     this.head.addBox(-3.0F, 0.0F, -3.0F, 7, 5, 7);
/*  43 */     this.head.setRotationPoint(0.0F, -6.0F, 0.0F);
/*  44 */     this.head.setTextureSize(128, 64);
/*  45 */     this.head.mirror = true;
/*  46 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  47 */     this.stem = new ModelRenderer(this, 49, 23);
/*  48 */     this.stem.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
/*  49 */     this.stem.setRotationPoint(0.0F, -8.0F, 0.0F);
/*  50 */     this.stem.setTextureSize(128, 64);
/*  51 */     this.stem.mirror = true;
/*  52 */     setRotation(this.stem, 0.1745329F, 0.0F, 0.1745329F);
/*  53 */     this.rarm = new ModelRenderer(this, 26, 0);
/*  54 */     this.rarm.addBox(-14.0F, 0.0F, 0.0F, 15, 1, 1);
/*  55 */     this.rarm.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  56 */     this.rarm.setTextureSize(128, 64);
/*  57 */     this.rarm.mirror = true;
/*  58 */     setRotation(this.rarm, 0.0F, 0.0F, 0.0F);
/*  59 */     this.larm = new ModelRenderer(this, 63, 0);
/*  60 */     this.larm.addBox(0.0F, 0.0F, 0.0F, 15, 1, 1);
/*  61 */     this.larm.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  62 */     this.larm.setTextureSize(128, 64);
/*  63 */     this.larm.mirror = true;
/*  64 */     setRotation(this.larm, 0.0F, 0.0F, 0.0F);
/*  65 */     this.rsleeve = new ModelRenderer(this, 31, 7);
/*  66 */     this.rsleeve.addBox(-11.0F, 0.0F, -1.0F, 9, 8, 3);
/*  67 */     this.rsleeve.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  68 */     this.rsleeve.setTextureSize(128, 64);
/*  69 */     this.rsleeve.mirror = true;
/*  70 */     setRotation(this.rsleeve, 0.0F, 0.0F, 0.0F);
/*  71 */     this.lsleeve = new ModelRenderer(this, 71, 7);
/*  72 */     this.lsleeve.addBox(3.0F, 0.0F, -1.0F, 9, 8, 3);
/*  73 */     this.lsleeve.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  74 */     this.lsleeve.setTextureSize(128, 64);
/*  75 */     this.lsleeve.mirror = true;
/*  76 */     setRotation(this.lsleeve, 0.0F, 0.0F, 0.0F);
/*  77 */     this.lchains = new ModelRenderer(this, 98, 0);
/*  78 */     this.lchains.addBox(11.0F, -1.0F, 0.0F, 3, 16, 1);
/*  79 */     this.lchains.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  80 */     this.lchains.setTextureSize(128, 64);
/*  81 */     this.lchains.mirror = true;
/*  82 */     setRotation(this.lchains, 0.0F, 0.0F, 0.0F);
/*  83 */     this.rchains = new ModelRenderer(this, 12, 0);
/*  84 */     this.rchains.addBox(-13.0F, -1.0F, 0.0F, 3, 10, 1);
/*  85 */     this.rchains.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  86 */     this.rchains.setTextureSize(128, 64);
/*  87 */     this.rchains.mirror = true;
/*  88 */     setRotation(this.rchains, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  93 */     GhostSkelly e = (GhostSkelly)entity;
/*  94 */     RenderInfo r = null;
/*  95 */     float newangle = 0.0F;
/*  96 */     float newrf1 = 0.0F;
/*     */     
/*  98 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  99 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/* 100 */     r = e.getRenderInfo();
/*     */     
/* 102 */     this.lchains.rotateAngleZ = MathHelper.cos(f2 * 0.2F) * 3.1415927F * 0.05F;
/* 103 */     this.rchains.rotateAngleZ = MathHelper.cos(f2 * 0.22F) * 3.1415927F * 0.05F;
/* 104 */     this.lchains.rotateAngleY = MathHelper.cos(f2 * 0.24F) * 3.1415927F * 0.05F;
/* 105 */     this.rchains.rotateAngleY = MathHelper.cos(f2 * 0.26F) * 3.1415927F * 0.05F;
/*     */ 
/*     */ 
/*     */     
/* 109 */     newangle = MathHelper.cos(f2 * 0.05F) * 3.1415927F * 2.0F;
/* 110 */     newrf1 = f2 * 0.05F % 6.2831855F;
/* 111 */     newrf1 = Math.abs(newrf1);
/*     */     
/* 113 */     if (newrf1 < r.rf2) {
/*     */       
/* 115 */       r.ri2 = 0;
/* 116 */       if (e.worldObj.rand.nextInt(3) == 1) r.ri2 |= 0x1; 
/*     */     } 
/* 118 */     r.rf2 = newrf1;
/* 119 */     if ((r.ri2 & 0x1) == 0) {
/* 120 */       newangle = 0.0F;
/*     */     }
/*     */     
/* 123 */     this.head.rotateAngleY = newangle;
/*     */ 
/*     */     
/* 126 */     e.setRenderInfo(r);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 131 */     GL11.glPushMatrix();
/* 132 */     GL11.glEnable(2977);
/* 133 */     GL11.glEnable(3042);
/* 134 */     GL11.glBlendFunc(770, 771);
/* 135 */     GL11.glColor4f(0.75F, 0.75F, 0.75F, 0.25F);
/*     */     
/* 137 */     this.body.render(f5);
/* 138 */     this.shirt.render(f5);
/* 139 */     this.head.render(f5);
/* 140 */     this.stem.render(f5);
/* 141 */     this.rarm.render(f5);
/* 142 */     this.larm.render(f5);
/* 143 */     this.rsleeve.render(f5);
/* 144 */     this.lsleeve.render(f5);
/* 145 */     this.lchains.render(f5);
/* 146 */     this.rchains.render(f5);
/*     */     
/* 148 */     GL11.glDisable(3042);
/* 149 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 154 */     model.rotateAngleX = x;
/* 155 */     model.rotateAngleY = y;
/* 156 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 161 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelGhostSkelly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */