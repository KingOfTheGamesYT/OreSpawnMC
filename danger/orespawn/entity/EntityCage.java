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
/*  36 */   private World throwerWorld = null;
/*  37 */   private EntityPlayer thrower = null;
/*     */   
/*     */   public EntityCage(World world) {
/*  40 */     super(world);
/*  41 */     this.throwerWorld = world;
/*     */   }
/*     */   
/*     */   public EntityCage(World par1World, EntityPlayer par2EntityLiving, Class<? extends Entity> my_class, @Nullable String customName) {
/*  45 */     super(par1World, (EntityLivingBase)par2EntityLiving);
/*  46 */     this.throwerWorld = par1World;
/*  47 */     this.thrower = par2EntityLiving;
/*  48 */     this.my_class = my_class;
/*  49 */     this.customName = customName;
/*  50 */     if (this.thrower.world != null) this.throwerWorld = this.thrower.world;
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
/*  66 */     if (this.my_class == null) {
/*  67 */       if (result.entityHit != null && this.rand.nextInt(10) >= 2) {
/*  68 */         if (this.throwerWorld != null) {
/*     */ 
/*     */           
/*  71 */           for (int var3 = 0; var3 < 4; var3++) {
/*  72 */             this.throwerWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, result.entityHit.posX, result.entityHit.posY + 0.25D, result.entityHit.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/*  73 */             this.throwerWorld.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, result.entityHit.posX, result.entityHit.posY + 0.25D, result.entityHit.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/*  74 */             this.throwerWorld.spawnParticle(EnumParticleTypes.REDSTONE, result.entityHit.posX, result.entityHit.posY + 0.25D, result.entityHit.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */           } 
/*  76 */           if (this.thrower != null) {
/*  77 */             this.thrower.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 1.5F);
/*     */           }
/*     */         } 
/*  80 */         Entity hit = result.entityHit;
/*     */         
/*  82 */         if (hit instanceof EntityLiving) {
/*  83 */           CritterCage cc = CritterCage.getCageFromEntity(hit);
/*  84 */           if (cc == null) {
/*     */             return;
/*     */           }
/*  87 */           if (this.rand.nextFloat() < cc.getChance() && 
/*  88 */             !this.world.isRemote) {
/*  89 */             dropItem((Item)cc, 1);
/*  90 */             ((EntityLiving)hit).setDropItemsWhenDead(false);
/*  91 */             ((EntityLiving)hit).setDead();
/*     */           }
/*     */         
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/*  99 */       result.getBlockPos();
/*     */       
/* 101 */       result.getBlockPos();
/* 102 */       BlockPos position = result.getBlockPos();
/* 103 */       if (result.entityHit != null)
/* 104 */         position = result.entityHit.getPosition(); 
/* 105 */       for (int i = 0; i < 6; i++) {
/* 106 */         this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/* 107 */         this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/* 108 */         this.world.spawnParticle(EnumParticleTypes.REDSTONE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/*     */       } 
/* 110 */       this.world.playSound(this.posX, this.posY, this.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.5F, true);
/*     */       
/* 112 */       Entity summon = EntityList.newEntity(this.my_class, this.world);
/* 113 */       System.out.println(summon);
/*     */       
/* 115 */       summon.setPosition(position.getX(), (position.getY() + 1), position.getZ());
/* 116 */       this.world.spawnEntity(summon);
/*     */ 
/*     */       
/* 119 */       EntityItem empty = new EntityItem(this.world);
/* 120 */       empty.setItem(new ItemStack(ModItems.EMPTY_CAGE));
/* 121 */       empty.setPosition(position.getX(), position.getY(), position.getZ());
/* 122 */       this.world.spawnEntity((Entity)empty);
/*     */       
/* 124 */       if (summon instanceof EntityLiving && this.customName != null) {
/* 125 */         summon.setCustomNameTag(this.customName);
/*     */       }
/*     */     } 
/* 128 */     if (!this.world.isRemote) {
/* 129 */       setDead();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 136 */     super.onUpdate();
/* 137 */     this.throwerWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12.2-public_development_0.5-deobf.jar!\danger\orespawn\entity\EntityCage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */