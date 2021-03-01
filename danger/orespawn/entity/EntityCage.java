/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.init.ModItems;
/*     */ import danger.orespawn.items.CritterCage;
/*     */ import javax.annotation.Nullable;
/*     */ import javax.annotation.ParametersAreNonnullByDefault;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.passive.EntityHorse;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityThrowable;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.SoundCategory;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityCage
/*     */   extends EntityThrowable
/*     */ {
/*     */   public Class<? extends Entity> my_class;
/*     */   public String customName;
/*  37 */   private World throwerWorld = null;
/*  38 */   private EntityPlayer thrower = null;
/*     */   
/*     */   public EntityCage(World world) {
/*  41 */     super(world);
/*  42 */     this.throwerWorld = world;
/*     */   }
/*     */   
/*     */   public EntityCage(World par1World, EntityPlayer par2EntityLiving, Class<? extends Entity> my_class, @Nullable String customName) {
/*  46 */     super(par1World, (EntityLivingBase)par2EntityLiving);
/*  47 */     this.throwerWorld = par1World;
/*  48 */     this.thrower = par2EntityLiving;
/*  49 */     this.my_class = my_class;
/*  50 */     this.customName = customName;
/*  51 */     if (this.thrower.world != null) this.throwerWorld = this.thrower.world;
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @ParametersAreNonnullByDefault
/*     */   protected void onImpact(RayTraceResult result) {
/*  67 */     if (this.my_class == null) {
/*  68 */       if (result.entityHit != null && this.rand.nextInt(10) >= 2) {
/*  69 */         if (this.throwerWorld != null) {
/*     */ 
/*     */           
/*  72 */           for (int var3 = 0; var3 < 4; var3++) {
/*  73 */             this.throwerWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, result.entityHit.posX, result.entityHit.posY + 0.25D, result.entityHit.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/*  74 */             this.throwerWorld.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, result.entityHit.posX, result.entityHit.posY + 0.25D, result.entityHit.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/*  75 */             this.throwerWorld.spawnParticle(EnumParticleTypes.REDSTONE, result.entityHit.posX, result.entityHit.posY + 0.25D, result.entityHit.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */           } 
/*  77 */           if (this.thrower != null) {
/*  78 */             this.thrower.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 1.5F);
/*     */           }
/*     */         } 
/*  81 */         Entity hit = result.entityHit;
/*     */         
/*  83 */         if (hit instanceof EntityLiving) {
/*  84 */           CritterCage cc = CritterCage.getCageFromEntity(hit);
/*  85 */           if (cc == null) {
/*     */             return;
/*     */           }
/*  88 */           if (this.rand.nextFloat() < cc.getChance() && 
/*  89 */             !this.world.isRemote) {
/*  90 */             dropItem((Item)cc, 1);
/*  91 */             ((EntityLiving)hit).setDropItemsWhenDead(false);
/*  92 */             ((EntityLiving)hit).setDead();
/*     */           }
/*     */         
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 100 */       result.getBlockPos();
/*     */       
/* 102 */       result.getBlockPos();
/* 103 */       BlockPos position = result.getBlockPos();
/* 104 */       if (result.entityHit != null)
/* 105 */         position = result.entityHit.getPosition(); 
/* 106 */       for (int i = 0; i < 6; i++) {
/* 107 */         this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/* 108 */         this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/* 109 */         this.world.spawnParticle(EnumParticleTypes.REDSTONE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/*     */       } 
/* 111 */       this.world.playSound(this.posX, this.posY, this.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.5F, true);
/*     */       
/* 113 */       Entity summon = EntityList.newEntity(this.my_class, this.world);
/* 114 */       System.out.println(summon);
/*     */       
/* 116 */       summon.setPosition(position.getX(), (position.getY() + 1), position.getZ());
/*     */       
/* 118 */       if (this.my_class == EntityHorse.class) {
/* 119 */         ((EntityHorse)summon).setHorseVariant(this.world.rand.nextInt());
/*     */       }
/* 121 */       this.world.spawnEntity(summon);
/*     */ 
/*     */       
/* 124 */       EntityItem empty = new EntityItem(this.world);
/* 125 */       empty.setItem(new ItemStack(ModItems.EMPTY_CAGE));
/* 126 */       empty.setPosition(position.getX(), position.getY(), position.getZ());
/* 127 */       this.world.spawnEntity((Entity)empty);
/*     */       
/* 129 */       if (summon instanceof EntityLiving && this.customName != null) {
/* 130 */         summon.setCustomNameTag(this.customName);
/*     */       }
/*     */     } 
/* 133 */     if (!this.world.isRemote) {
/* 134 */       setDead();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 141 */     super.onUpdate();
/* 142 */     this.throwerWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.7-deobf.jar!\danger\orespawn\entity\EntityCage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */